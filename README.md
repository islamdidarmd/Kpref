# EasyAdapter
A class that saves time of writing boilerplate code for saving any kind of data in shared preferences

[![](https://jitpack.io/v/islamdidarmd/Kpref.svg)](https://jitpack.io/#islamdidarmd/Kpref)

## Installation (with Gradle)
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```groovy
   allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency

```groovy
dependencies {
		implementation 'com.github.islamdidarmd:kprefs:0.1.0'
	}
```
	
### How to use

```kotlin
        //save values in a default sharedPreference
        Kprefs.initDefault(this)

        Kprefs.save("test", 10)

        val x: Int? = Kprefs.get("", Int::class.java)


        //save values in your preference
        val pref = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
        Kprefs.init(pref)

        Kprefs.save("testMyPref", "Saved")

        val value: String? = Kprefs.get("", String::class.java)
```


You must call `Kprefs.initDefault(this)` or `Kprefs.init(pref)` before calling any methods
For a complete example, see the sample app
