// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    // Apply Hilt plugin at the top level
    id("com.google.dagger.hilt.android") version "2.48" apply false
}
