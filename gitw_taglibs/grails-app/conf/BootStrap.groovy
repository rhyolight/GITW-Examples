class BootStrap {

     def init = { servletContext ->
         new Bar(name:'bar none').save()
         new Bar(name:'bar one').save()
         new Bar(name:'bar two').save()
         new Bar(name:'bar three').save()
     }
     def destroy = {
     }
} 