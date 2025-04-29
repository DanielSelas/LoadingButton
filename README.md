# LoadingButton

A lightweight and customizable Android library for loading buttons with dynamic text and background color change.  
Ideal for actions like submitting forms, uploading files, or signing in.

---

## Demo

<p align="center">
  <img src="https://github.com/DanielSelas/LoadingButton/assets/123456/Screenshot_before.png" width="45%" />
  <img src="https://github.com/DanielSelas/LoadingButton/assets/123456/Screenshot_after.png" width="45%" />
</p>

---

## Features

- Customizable loading text and loading color per button.
- Automatically restores original text and color after loading finishes.
- Easy to integrate into any Android project.
- Clean and lightweight design.

---

## Usage

### 1. Add LoadingButton to your XML

```xml
<com.example.loadingbutton.LoadingButton
    android:id="@+id/buttonSimple"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Simple Action"
    android:backgroundTint="@color/neutral_light_gray"
    android:layout_marginBottom="24dp" />

### 2. Control the button from your Java code

```Java
LoadingButton buttonSimple = findViewById(R.id.buttonSimple);

buttonSimple.setLoadingText("Loading...");
buttonSimple.setLoadingColor(R.color.pastel_green); // Custom color for loading state

buttonSimple.setOnClickListener(v -> {
    buttonSimple.showLoading();
    
    new Handler(Looper.getMainLooper()).postDelayed(() -> {
        buttonSimple.hideLoading();
    }, 2000); // Simulated loading
});


How It Works
	•	Normal State:
The button shows its original text and background color.
	•	Loading State:
The text changes to a custom loading message and the background color changes.
	•	Finished State:
The button automatically returns to its original text and color.
