
# react-native-rn-keep-screen-on

## Getting started

`$ npm install react-native-rn-keep-screen-on --save`

### Mostly automatic installation

`$ react-native link react-native-rn-keep-screen-on`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-rn-keep-screen-on` and add `RNRnKeepScreenOn.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNRnKeepScreenOn.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNRnKeepScreenOnPackage;` to the imports at the top of the file
  - Add `new RNRnKeepScreenOnPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-rn-keep-screen-on'
  	project(':react-native-rn-keep-screen-on').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-rn-keep-screen-on/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-rn-keep-screen-on')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNRnKeepScreenOn.sln` in `node_modules/react-native-rn-keep-screen-on/windows/RNRnKeepScreenOn.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Rn.Keep.Screen.On.RNRnKeepScreenOn;` to the usings at the top of the file
  - Add `new RNRnKeepScreenOnPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNRnKeepScreenOn from 'react-native-rn-keep-screen-on';

// TODO: What to do with the module?
RNRnKeepScreenOn;
```
  