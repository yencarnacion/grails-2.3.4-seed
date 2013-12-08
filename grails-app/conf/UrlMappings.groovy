class UrlMappings {

	static mappings = {

        "/home/loginSuccess" (controller: "loginSuccess")

        "/"(view:"/index")
        "500"(view:'/error')

        "/home/dashboard" (view: "/dashboard")
        "/secure/dashboard" (view: "/dashboard")

        "/secure/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }


	}
}
