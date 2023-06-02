package uz.akbarali.fashion.ui.modal

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import uz.akbarali.fashion.R

object Download {
    fun linkFromDownload(context: Context, url: String, subUrl: String, fileName: String) {
        MaterialAlertDialogBuilder(context)
            .setTitle(R.string.title)
            .setIcon(R.drawable.icon__3_)
            .setMessage(R.string.supporting_text)
            .setNegativeButton(R.string.decline) { dialog, which ->

            }
            .setPositiveButton(R.string.accept) { dialog, which ->
                val request: DownloadManager.Request = DownloadManager.Request(Uri.parse(url))
                request.setDescription("Downloading File please wait.....")
                request.addRequestHeader(
                    "referer",
                    subUrl
                ).setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_DOWNLOADS,
                    fileName
                )
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                val downloadManager =
                    context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                downloadManager.enqueue(request)

            }.show()
    }
}