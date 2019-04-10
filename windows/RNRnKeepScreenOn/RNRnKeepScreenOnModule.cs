using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Rn.Keep.Screen.On.RNRnKeepScreenOn
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNRnKeepScreenOnModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNRnKeepScreenOnModule"/>.
        /// </summary>
        internal RNRnKeepScreenOnModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNRnKeepScreenOn";
            }
        }
    }
}
