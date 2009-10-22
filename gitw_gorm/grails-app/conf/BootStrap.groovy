class BootStrap {

     def init = { servletContext ->
         def steve = new Foo(name:'Steve').save()
         def susan = new Bar(name:'Susan').save()
         steve.addToBars(susan)
         
         new Baz(name:'Wilma', location:'Bedrock', favoriteColor:'yellow').save()
         new Baz(name:'George', location:'the FUTURE', favoriteColor:'cyan').save()
         new Baz(name:'Scooby', location:'the Mystery Machine', favoriteColor:'brown').save()
         new Baz(name:'He-Man', location:'Greyskull', favoriteColor:'red').save()
         new Baz(name:'Smurfette', location:'Smurf Village', favoriteColor:'blue').save()
         
     }
     def destroy = {
     }
} 