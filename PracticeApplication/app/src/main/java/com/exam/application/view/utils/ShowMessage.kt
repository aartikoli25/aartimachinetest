package com.exam.application.view.utils

import android.content.Context
import android.content.Intent
import cn.pedant.SweetAlert.SweetAlertDialog
import com.exam.application.MainActivity
import com.exam.application.R

object ShowMessage {

    fun showError(context: Context?, message: String?) {
        SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("Error...")
            .setContentText(message)
            .show()
    }

    fun showInfo(context: Context?, message: String?) {
        SweetAlertDialog(context, SweetAlertDialog.NORMAL_TYPE)
            .setTitleText("Message")
            .setContentText(message)
            .show()
    }

    fun showSuccess(context: Context?, message: String?) {
        SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText(message)
            .setConfirmClickListener {
                context!!.startActivity(
                    Intent(
                        context,
                        MainActivity::class.java
                    ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                )

            }
            .show()
    }

    fun showLoading(context: Context?): SweetAlertDialog {
        val loader: SweetAlertDialog
        loader = SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
        loader.setCancelable(true)
        loader.titleText = "Please wait.."
        return loader
    }

    fun showInfoImage(context: Context?, message: String?) {
        SweetAlertDialog(context, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
            .setTitleText("No Data!")
            .setCustomImage(R.drawable.ic_info)
            .setContentText(message)
            .show()
    }
}