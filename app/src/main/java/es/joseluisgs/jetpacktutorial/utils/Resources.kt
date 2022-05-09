package es.joseluisgs.jetpacktutorial.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable

/**
 * Obtiene una imagen desde un recurso de drawable
 */
fun getImageSrc(name: String, context: Context?): Drawable? {
    return context?.let {
        val resources: Resources = context.resources
        val resourceId: Int = resources.getIdentifier(
            name, "drawable",
            context.packageName
        )
        resources.getDrawable(resourceId, null)
    }
}