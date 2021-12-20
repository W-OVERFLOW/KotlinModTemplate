//#if MODERN==0 || FABRIC==1
package com.example.template.config

import com.example.template.ModTemplate
import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType
import java.io.File


object TemplateConfig : Vigilant(File(ModTemplate.modDir, "${ModTemplate.ID}.toml"), ModTemplate.NAME) {

    @Property(
        type = PropertyType.SWITCH,
        name = "Hello!",
        description = "Thanks for using this template!",
        category = "General"
    )
    var testProperty = false

    init {
        initialize()
    }
}
//#endif