import React, { Component } from 'react'
import { View } from 'react-native'
import {createAppContainer} from 'react-navigation'
import NavStore from '../AppStores/NavStore'
import PopupCustom from '../components/elements/PopupCustom'
import CustomToastTop from '../components/elements/CustomToastTop'
import NotificationInApp from '../components/elements/NotificationInApp'
import Router from './Router'

const AppContainer = createAppContainer(Router)

export default class MainStack extends Component {
  render() {
    return (
      <View style={{ flex: 1 }}>
        <AppContainer
          onNavigationStateChange={(prev, next) => NavStore.onNavigationStateChange(prev, next)}
          ref={(ref) => { NavStore.navigator = ref }}
        />
        <PopupCustom
          ref={(popup) => {
            NavStore.popupCustom = popup
          }}
        />
        <CustomToastTop
          ref={(ref) => {
            NavStore.toastTop = ref
          }}
        />
        <NotificationInApp />
      </View>
    )
  }
}
