

class BarController {
    
    def index = {
        redirect action:"list", params:params 
    }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ barInstanceList: Bar.list( params ), barInstanceTotal: Bar.count() ]
    }

    def show = {
        def barInstance = Bar.get( params.id )

        if(!barInstance) {
            flash.message = "Bar not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            [ barInstance : barInstance ]
        }
    }

    def delete = {
        def barInstance = Bar.get( params.id )
        if(barInstance) {
            try {
                barInstance.delete(flush:true)
                flash.message = "Bar ${params.id} deleted"
                redirect(action:"list")
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Bar ${params.id} could not be deleted"
                redirect(action:"show",id:params.id)
            }
        }
        else {
            flash.message = "Bar not found with id ${params.id}"
            redirect(action:"list")
        }
    }

    def edit = {
        def barInstance = Bar.get( params.id )

        if(!barInstance) {
            flash.message = "Bar not found with id ${params.id}"
            redirect action:'list'
        }
        else {
            return [ barInstance : barInstance ]
        }
    }

    def update = {
        def barInstance = Bar.get( params.id )
        if(barInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(barInstance.version > version) {
                    
                    barInstance.errors.rejectValue("version", "bar.optimistic.locking.failure", "Another user has updated this Bar while you were editing.")

                    render view:'edit', model:[barInstance:barInstance]
                    return
                }
            }
            barInstance.properties = params
            if(!barInstance.hasErrors() && barInstance.save()) {
                flash.message = "Bar ${params.id} updated"

                redirect action:'show', id:barInstance.id
            }
            else {
                render view:'edit', model:[barInstance:barInstance]
            }
        }
        else {
            flash.message = "Bar not found with id ${params.id}"
            redirect action:'list'
        }
    }

    def create = {
        def barInstance = new Bar()
        barInstance.properties = params
        return ['barInstance':barInstance]
    }

    def save = {
        def barInstance = new Bar(params)
        if(barInstance.save(flush:true)) {
            flash.message = "Bar ${barInstance.id} created"

            redirect action:"show", id:barInstance.id
        }
        else {
            render view:'create', model:[barInstance:barInstance]
        }
    }
}
