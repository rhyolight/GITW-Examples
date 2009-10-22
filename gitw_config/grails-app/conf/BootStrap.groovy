class BootStrap {

     def init = { servletContext ->
         new Foo(name:'Matt', birthDate:[78,6,11] as Date).save()
         new Foo(name:'Trinity', birthDate:[79,3,16] as Date).save()
         new Foo(name:'Dean', birthDate:[105,0,20] as Date).save()
         new Foo(name:'Romy', birthDate:[107,8,3] as Date).save()
     }
     def destroy = {
     }
} 