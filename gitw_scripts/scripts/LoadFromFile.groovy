import org.springframework.orm.hibernate3.SessionHolder
import org.springframework.orm.hibernate3.SessionFactoryUtils
import org.springframework.transaction.support.TransactionSynchronizationManager
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import grails.util.*

grailsHome = Ant.project.properties."environment.GRAILS_HOME"

includeTargets << grailsScript("Init")
includeTargets << new File("${grailsHome}/scripts/Bootstrap.groovy")

target(main: "Load stuff from file") {
    if (!args) {
        println "please provide name of input file"
        return
    }
    
    packageApp()
    classLoader = new URLClassLoader([classesDir.toURL()] as URL[], rootLoader)
    Thread.currentThread().setContextClassLoader(classLoader)
    loadApp()
    configureApp()

    sessionFactory = grailsApp.mainContext.getBean("sessionFactory")
    session = SessionFactoryUtils.getSession(sessionFactory, true)
    TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session))
    
    def fooClass = grailsApp.getDomainClass("Foo").clazz
    new File(args).eachLine {
        fooClass.newInstance(name:it).save()
    }
}

setDefaultTarget(main)
