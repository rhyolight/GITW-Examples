

class BazController {
    
    def index = {
        redirect action:"list", params:params 
    }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def finder = {
        def props = grailsApplication.getDomainClass(Baz.class.name).persistentProperties
        [findableProperties:props*.name]
    }
    
    def bazFindBy = {
        def baz = Baz."findBy${params.findBy}"(params.value)
        render(template:'bazDetail', var:'bazInstance', bean:baz)
    }
    
    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ bazInstanceList: Baz.list( params ), bazInstanceTotal: Baz.count() ]
    }

    def show = {
        def bazInstance = Baz.get( params.id )

        if(!bazInstance) {
            flash.message = "Baz not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            [ bazInstance : bazInstance ]
        }
    }

    def delete = {
        def bazInstance = Baz.get( params.id )
        if(bazInstance) {
            try {
                bazInstance.delete(flush:true)
                flash.message = "Baz ${params.id} deleted"
                redirect(action:"list")
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Baz ${params.id} could not be deleted"
                redirect(action:"show",id:params.id)
            }
        }
        else {
            flash.message = "Baz not found with id ${params.id}"
            redirect(action:"list")
        }
    }

    def edit = {
        def bazInstance = Baz.get( params.id )

        if(!bazInstance) {
            flash.message = "Baz not found with id ${params.id}"
            redirect action:'list'
        }
        else {
            return [ bazInstance : bazInstance ]
        }
    }

    def update = {
        def bazInstance = Baz.get( params.id )
        if(bazInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(bazInstance.version > version) {
                    
                    bazInstance.errors.rejectValue("version", "baz.optimistic.locking.failure", "Another user has updated this Baz while you were editing.")

                    render view:'edit', model:[bazInstance:bazInstance]
                    return
                }
            }
            bazInstance.properties = params
            if(!bazInstance.hasErrors() && bazInstance.save()) {
                flash.message = "Baz ${params.id} updated"

                redirect action:'show', id:bazInstance.id
            }
            else {
                render view:'edit', model:[bazInstance:bazInstance]
            }
        }
        else {
            flash.message = "Baz not found with id ${params.id}"
            redirect action:'list'
        }
    }

    def create = {
        def bazInstance = new Baz()
        bazInstance.properties = params
        return ['bazInstance':bazInstance]
    }

    def save = {
        def bazInstance = new Baz(params)
        if(bazInstance.save(flush:true)) {
            flash.message = "Baz ${bazInstance.id} created"

            redirect action:"show", id:bazInstance.id
        }
        else {
            render view:'create', model:[bazInstance:bazInstance]
        }
    }
}
