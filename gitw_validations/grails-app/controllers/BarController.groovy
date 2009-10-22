class BarController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.max.toInteger() : 10, 100)
        [barInstanceList: Bar.list(params), barInstanceTotal: Bar.count()]
    }

    def create = {
        def barInstance = new Bar()
        barInstance.properties = params
        return [barInstance: barInstance]
    }

    def save = {
        def barInstance = new Bar(params)
        if (barInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'bar.label', default: 'Bar'), barInstance.id])}"
            redirect(action: "show", id: barInstance.id)
        }
        else {
            render(view: "create", model: [barInstance: barInstance])
        }
    }

    def show = {
        def barInstance = Bar.get(params.id)
        if (!barInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bar.label', default: 'Bar'), params.id])}"
            redirect(action: "list")
        }
        else {
            [barInstance: barInstance]
        }
    }

    def edit = {
        def barInstance = Bar.get(params.id)
        if (!barInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bar.label', default: 'Bar'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [barInstance: barInstance]
        }
    }

    def update = {
        def barInstance = Bar.get(params.id)
        if (barInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (barInstance.version > version) {
                    
                    barInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'bar.label', default: 'Bar')], "Another user has updated this Bar while you were editing")
                    render(view: "edit", model: [barInstance: barInstance])
                    return
                }
            }
            barInstance.properties = params
            if (!barInstance.hasErrors() && barInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'bar.label', default: 'Bar'), barInstance.id])}"
                redirect(action: "show", id: barInstance.id)
            }
            else {
                render(view: "edit", model: [barInstance: barInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bar.label', default: 'Bar'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def barInstance = Bar.get(params.id)
        if (barInstance) {
            try {
                barInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'bar.label', default: 'Bar'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'bar.label', default: 'Bar'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'bar.label', default: 'Bar'), params.id])}"
            redirect(action: "list")
        }
    }
}
