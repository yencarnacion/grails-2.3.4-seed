package seed

class WebflowController {

    def index() {
        redirect(action: 'webflow', params: params)
    }

    def webflowFlow = {
        decideCreateOrEdit {
            action {
                if(params.id){
                    flow.contentMaterialInstance = ContentMaterial.get(params.id)
                } else {
                    flow.contentMaterialInstance = new ContentMaterial()
                    //Display error message
                }
                if (!flow.contentMaterialInstance.content) {
                    flow.newContent = true
                    if (!flow.contentMaterialInstance) {
                        flow.contentMaterialInstance = new ContentMaterial();
                    }
                    flow.contentMaterialInstance.content = "seedData"
                } else {
                    flow.newContent = false
                }
                System.out.println("content:" + flow.contentMaterialInstance.content)


                //flow.contentMaterialInstance.save(flush: true)
                //log.debug("*******"+flow.contentMaterialInstance.dump())

            }
            on("success").to "enterContent"
            on(Exception).to "handleError"
        }
        enterContent{
            on("back") {
                flow.contentMaterialInstance.content = params.contentMaterialInstance.content
                if (!flow.contentMaterialInstance.content) return error()

                //flow.contentMaterialInstance.save(flush: true)
            }.to "enterContent"
            on("next") {
                log.debug("params:"+ params)
                flow.contentMaterialInstance.content = params.contentMaterialInstance.content

                if (!flow.contentMaterialInstance.content) return error()
                //flow.contentMaterialInstance.save(flush: true)
            }.to "displayContentMaterial"
            on("save") {
                flow.contentMaterialInstance.content = params.contentMaterialInstance.content

                if (!flow.contentMaterialInstance.content) return error()
                flow.contentMaterialInstance.save(flush: true)
            }.to "enterContent"
        }
        displayContentMaterial{
            on("back") {
                flow.contentMaterialInstance
            }.to "enterContent"

        }
        handleError()
    }
}