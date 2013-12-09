class UrlMappings {

	static mappings = {

        "/home/loginSuccess" (controller: "loginSuccess")
        "/login/$action" (controller: "login")
        "/logout/$action" (controller:  "logout")

        "/"(view:"/index")
        "500"(view:'/error')

        "/home/dashboard" (view: "/dashboard")
        "/home/webflow/$action?/$id?(.${format})?" (controller: "webflow")

        "/secure/dashboard" (view: "/dashboard")

        "/secure/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }


	}
}
