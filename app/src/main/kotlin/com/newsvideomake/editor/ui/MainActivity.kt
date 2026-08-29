package com.newsvideomake.editor.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newsvideomake.editor.databinding.ActivityMainBinding

/**
 * MainActivity - Entry point for the News Video Maker application.
 * Displays welcome screen with options to create new video or open recent projects.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up toolbar if needed
        setSupportActionBar(binding.toolbar)

        // Initialize UI click listeners
        setupClickListeners()
    }

    /**
     * Setup click listeners for main action buttons
     */
    private fun setupClickListeners() {
        // "Create New Video" button - Navigate to template selection
        binding.btnNewProject.setOnClickListener {
            navigateToTemplateSelection()
        }

        // "Open Recent Project" button - Future implementation for recent projects
        binding.btnOpenRecent.setOnClickListener {
            // TODO: Implement recent projects screen
            showToast("Recent projects feature coming soon!")
        }
    }

    /**
     * Navigate to template selection screen
     */
    private fun navigateToTemplateSelection() {
        val intent = Intent(this, TemplateSelectionActivity::class.java)
        startActivity(intent)
    }

    /**
     * Helper function to show toast messages
     */
    private fun showToast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        // Refresh any data if needed
    }

    override fun onPause() {
        super.onPause()
        // Save any temporary state if needed
    }
}
