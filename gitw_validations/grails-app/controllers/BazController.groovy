class BazController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.max.toInteger() : 10, 100)
        [bazInstanceList: Baz.list(params), bazInstanceTotal: Baz.count()]
    }

    def create = {
        def bazInstance = new Baz()
        bazInstance.properties = params
        return [bazInstance: bazInstance]
    }
    
    def ajaxCreate = {
        def baz = new Baz(params)
        if (baz.validate()) {
            baz.save()
            return render(template:'bazDetail', var:'baz', bean:baz)
        }
        return render(template:'bazErrors', var:'baz', bean:baz)
    }

    def save = {
        def bazInstance = new Baz(params)
        if (bazInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'baz.label', default: 'Baz'), bazInstance.id])}"
            redirect(action: "show", id: bazInstance.id)
        }
        else {
            render(view: "create", model: [bazInstance: bazInstance])
        }
    }

    def show = {
        def bazInstance = Baz.get(params.id)
        if (!bazInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'baz.label', default: 'Baz'), params.id])}"
            redirect(action: "list")
        }
        else {
            [bazInstance: bazInstance]
        }
    }

    def edit = {
        def bazInstance = Baz.get(params.id)
        if (!bazInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'baz.label', default: 'Baz'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [bazInstance: bazInstance]
        }
    }

    def update = {
        def bazInstance = Baz.get(params.id)
        if (bazInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (bazInstance.version > version) {
                    
                    bazInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'baz.label', default: 'Baz')], "Another user has updated this Baz while you were editing")
                    render(view: "edit", model: [bazInstance: bazInstance])
                    return
                }
            }
            bazInstance.properties = params
            if (!bazInstance.hasErrors() && bazInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'baz.label', default: 'Baz'), bazInstance.id])}"
                redirect(action: "show", id: bazInstance.id)
            }
            else {
                render(view: "edit", model: [bazInstance: bazInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'baz.label', default: 'Baz'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def bazInstance = Baz.get(params.id)
        if (bazInstance) {
            try {
                bazInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'baz.label', default: 'Baz'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'baz.label', default: 'Baz'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'baz.label', default: 'Baz'), params.id])}"
            redirect(action: "list")
        }
    }
}
