# 👁️ Text Detector

**Text Detector** is an efficient Android application that uses Machine Learning to recognize and extract text from images. Utilizing the device's camera, this app converts printed text on documents, notes, or signs into digital format instantly.

## 📖 About the Project
Digitizing physical text shouldn't be hard. This application utilizes **Google's ML Kit** to provide accurate, on-device Optical Character Recognition (OCR) capabilities. It is designed to be a simple, lightweight tool for quick text extraction without needing complex setups.

## ✨ Key Features
| Feature | Description |
| :--- | :--- |
| 📸 **Camera Capture** | Capture an image directly using your device's default camera to begin the extraction process. |
| 🧠 **Smart Recognition** | Uses powerful on-device Machine Learning models to accurately detect text. |
| 📋 **Copy to Clipboard** | Easily copy the extracted text with a single tap for use in other applications. |

## 🛠️ Tech Stack & Libraries
This project is built with a focus on simplicity and performance using native Android tools.

* **Language:** Java
* **UI/Layout:** XML
* **ML Library:** [Google ML Kit (Text Recognition)](https://developers.google.com/ml-kit/vision/text-recognition/android)
* **Camera:** Android Native Camera Intent (`MediaStore`)

## 🚀 Getting Started

### Prerequisites
* **Android Studio** (Latest version recommended)
* **Android Device** or Emulator

### Installation

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/dhruvpatil1606/Text-Detector.git](https://github.com/dhruvpatil1606/Text-Detector.git)
    ```
2.  **Open in Android Studio:**
    * Launch Android Studio.
    * Select **File > Open** and navigate to the cloned `Text-Detector` folder.
3.  **Sync Gradle:**
    * Wait for the project to build and download the necessary ML Kit dependencies.
4.  **Run the App:**
    * Connect your physical device via USB or start an emulator.
    * Click the **Run** (Play) button in Android Studio.

## 📸 Screenshots & Demo

<div align="center">
  <img src="https://github.com/user-attachments/assets/1d71e5d8-8191-4ffe-9a4a-645da65f54ee" width="40%" alt="App Home Screen">
  <img src="https://github.com/user-attachments/assets/7b2218dc-2c20-4273-964f-20c9ffe5e94e" width="40%" alt="Text Detection Result">
</div>

### 🎥 Watch the Demo
[Click here to see the app in action (Screen Recording)](https://github.com/user-attachments/assets/29e40319-10cc-41d7-8de5-5fb83c9ccc6a)

<br>

## 🤝 Contributing

Contributions are welcome!
1.  Fork the repository.
2.  Create a new branch (`git checkout -b feature/YourFeature`).
3.  Commit your changes (`git commit -m 'Add some feature'`).
4.  Push to the branch (`git push origin feature/YourFeature`).
5.  Open a Pull Request.

## 📜 License

This project is licensed under the [MIT License](LICENSE).
