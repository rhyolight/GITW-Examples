

class FooController {
    
    def index = {
        redirect action:"list", params:params 
    }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ fooInstanceList: Foo.list( params ), fooInstanceTotal: Foo.count() ]
    }
    
    def detailOnly = {
        def foo = Foo.get(params.id)
        render(template:'fooDetail', var:'fooInstance', bean:foo)
    }

    def show = {
        def fooInstance = Foo.get( params.id )

        if(!fooInstance) {
            flash.message = "Foo not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            [ fooInstance : fooInstance ]
        }
    }

    def delete = {
        def fooInstance = Foo.get( params.id )
        if(fooInstance) {
            try {
                fooInstance.delete(flush:true)
                flash.message = "Foo ${params.id} deleted"
                redirect(action:"list")
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Foo ${params.id} could not be deleted"
                redirect(action:"show",id:params.id)
            }
        }
        else {
            flash.message = "Foo not found with id ${params.id}"
            redirect(action:"list")
        }
    }

    def edit = {
        def fooInstance = Foo.get( params.id )

        if(!fooInstance) {
            flash.message = "Foo not found with id ${params.id}"
            redirect action:'list'
        }
        else {
            return [ fooInstance : fooInstance ]
        }
    }

    def update = {
        def fooInstance = Foo.get( params.id )
        if(fooInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(fooInstance.version > version) {
                    
                    fooInstance.errors.rejectValue("version", "foo.optimistic.locking.failure", "Another user has updated this Foo while you were editing.")

                    render view:'edit', model:[fooInstance:fooInstance]
                    return
                }
            }
            fooInstance.properties = params
            if(!fooInstance.hasErrors() && fooInstance.save()) {
                flash.message = "Foo ${params.id} updated"

                redirect action:'show', id:fooInstance.id
            }
            else {
                render view:'edit', model:[fooInstance:fooInstance]
            }
        }
        else {
            flash.message = "Foo not found with id ${params.id}"
            redirect action:'list'
        }
    }

    def create = {
        def fooInstance = new Foo()
        fooInstance.properties = params
        return ['fooInstance':fooInstance]
    }

    def save = {
        def fooInstance = new Foo(params)
        if(fooInstance.save(flush:true)) {
            flash.message = "Foo ${fooInstance.id} created"

            redirect action:"show", id:fooInstance.id
        }
        else {
            render view:'create', model:[fooInstance:fooInstance]
        }
    }
}
