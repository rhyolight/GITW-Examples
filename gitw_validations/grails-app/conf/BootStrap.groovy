class BootStrap {

     def init = { servletContext ->
         new Bar(name:'a bar').save()
         new Bar(name:'b bar').save()
         new Bar(name:'c bar').save()
     }
     def destroy = {
     }
} 