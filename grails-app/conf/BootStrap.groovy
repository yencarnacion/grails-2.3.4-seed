import seed.auth.User
import seed.auth.Role
import seed.auth.UserRole

class BootStrap {

    def init = { servletContext ->

        switch (grails.util.Environment.current.name){
            case "development":

                def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true)
                def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(flush: true)

                def admin = User.get(1);
                if(!admin){
                    admin = new User(
                            id: 1,
                            username: "admin",
                            password: "password",
                            enabled: true,
                    ).save(flush: true, failOnError: true)
                    UserRole.create admin, adminRole
                }

                break;

            case "test":

                def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true)
                def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(flush: true)

                def admin = User.get(1);
                if(!admin){
                    admin = new User(
                            id: 1,
                            username: "admin",
                            password: "password",
                            enabled: true,
                    ).save(flush: true, failOnError: true)
                    UserRole.create admin, adminRole
                }

                break;

            case "production":

                def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true)
                def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(flush: true)

                def admin = User.get(1);
                if(!admin){
                    admin = new User(
                            id: 1,
                            username: "admin",
                            password: "password",
                            enabled: true,
                    ).save(flush: true)
                    UserRole.create admin, adminRole
                }

                break;
        }

    }
    def destroy = {
    }
}
