

class FooBarLinkController {
    
    def index = {
        redirect action:"list", params:params 
    }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ fooBarLinkInstanceList: FooBarLink.list( params ), fooBarLinkInstanceTotal: FooBarLink.count() ]
    }

    def show = {
        def fooBarLinkInstance = FooBarLink.get( params.id )

        if(!fooBarLinkInstance) {
            flash.message = "FooBarLink not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            [ fooBarLinkInstance : fooBarLinkInstance ]
        }
    }

    def delete = {
        def fooBarLinkInstance = FooBarLink.get( params.id )
        if(fooBarLinkInstance) {
            try {
                fooBarLinkInstance.delete(flush:true)
                flash.message = "FooBarLink ${params.id} deleted"
                redirect(action:"list")
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "FooBarLink ${params.id} could not be deleted"
                redirect(action:"show",id:params.id)
            }
        }
        else {
            flash.message = "FooBarLink not found with id ${params.id}"
            redirect(action:"list")
        }
    }

    def edit = {
        def fooBarLinkInstance = FooBarLink.get( params.id )

        if(!fooBarLinkInstance) {
            flash.message = "FooBarLink not found with id ${params.id}"
            redirect action:'list'
        }
        else {
            return [ fooBarLinkInstance : fooBarLinkInstance ]
        }
    }

    def update = {
        def fooBarLinkInstance = FooBarLink.get( params.id )
        if(fooBarLinkInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(fooBarLinkInstance.version > version) {
                    
                    fooBarLinkInstance.errors.rejectValue("version", "fooBarLink.optimistic.locking.failure", "Another user has updated this FooBarLink while you were editing.")

                    render view:'edit', model:[fooBarLinkInstance:fooBarLinkInstance]
                    return
                }
            }
            fooBarLinkInstance.properties = params
            if(!fooBarLinkInstance.hasErrors() && fooBarLinkInstance.save()) {
                flash.message = "FooBarLink ${params.id} updated"

                redirect action:'show', id:fooBarLinkInstance.id
            }
            else {
                render view:'edit', model:[fooBarLinkInstance:fooBarLinkInstance]
            }
        }
        else {
            flash.message = "FooBarLink not found with id ${params.id}"
            redirect action:'list'
        }
    }

    def create = {
        def fooBarLinkInstance = new FooBarLink()
        fooBarLinkInstance.properties = params
        return ['fooBarLinkInstance':fooBarLinkInstance]
    }

    def save = {
        def fooBarLinkInstance = new FooBarLink(params)
        if(fooBarLinkInstance.save(flush:true)) {
            flash.message = "FooBarLink ${fooBarLinkInstance.id} created"

            redirect action:"show", id:fooBarLinkInstance.id
        }
        else {
            render view:'create', model:[fooBarLinkInstance:fooBarLinkInstance]
        }
    }
}
