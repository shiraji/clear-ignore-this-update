package com.github.shiraji.clearignorethisupdate

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ex.ApplicationEx
import com.intellij.openapi.updateSettings.impl.UpdateSettings

class ClearIgnoreThisUpdate : AnAction() {
    override fun actionPerformed(e: AnActionEvent?) {
        UpdateSettings.getInstance().ignoredBuildNumbers.clear()
        val app = ApplicationManager.getApplication() as ApplicationEx
        app.restart(true)
    }

    override fun update(e: AnActionEvent?) {
        e ?: return
        super.update(e)
        e.presentation.isEnabled = UpdateSettings.getInstance().ignoredBuildNumbers.size > 0
    }
}