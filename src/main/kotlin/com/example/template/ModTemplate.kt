//#if MODERN==0 || FABRIC==1
package com.example.template

import cc.woverflow.onecore.utils.Updater
import cc.woverflow.onecore.utils.command
import cc.woverflow.onecore.utils.openScreen
import com.example.template.config.TemplateConfig
import java.io.File

//#if MODERN==0
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
//#else
//$$ import cc.woverflow.onecore.utils.getFileOfMod
//#endif

//#if MODERN==0
@Mod(
    modid = ModTemplate.ID,
    name = ModTemplate.NAME,
    version = ModTemplate.VER,
    modLanguageAdapter = "gg.essential.api.utils.KotlinAdapter"
)
//#endif
object ModTemplate {

    const val NAME = "@NAME@"
    const val VER = "@VER@"
    const val ID = "@ID@"

    val modDir = File(File("./W-OVERFLOW"), NAME)

    //#if MODERN==0
    @Mod.EventHandler
    fun onPreInit(event: FMLPreInitializationEvent)
    //#else
    //$$ fun onPreInit()
    //#endif
    {
        if (!modDir.exists()) modDir.mkdirs()
        //#if FABRIC==1
        //$$ val file = getFileOfMod(ID)
        //$$ if (file == null) return
        //#endif
        Updater.addToUpdater(
            //#if FABRIC==0
            event.sourceFile
            //#else
            //$$ file
            //#endif
            , NAME, ID, VER, "W-OVERFLOW/$ID")
    }

    //#if MODERN==0
    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent)
    //#else
    //$$ fun onInit()
    //#endif
    {
        //#if MODERN==1
        //$$ onPreInit()
        //#endif
        TemplateConfig.preload()
        command(ID) {
            main {
                TemplateConfig.openScreen()
            }
        }
    }
}
//#endif