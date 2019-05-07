/**
 * Created by LiuLei on 2019-05-07
 */
import React, { Component } from 'react'
import {
  Animated,
  Easing,
  StyleSheet,
} from 'react-native'
import images from '../../commons/images'

const circleSize = 120

export default class GoldenLoading extends Component {
  constructor () {
    super()
    this.spinValue = new Animated.Value(0)
  }

  componentDidMount () {
    this.spin()
  }

  //旋转方法
  spin = () => {
    this.spinValue.setValue(0)
    Animated.timing(this.spinValue, {
      toValue: 1, // 最终值 为1，这里表示最大旋转 360度
      duration: 4000,
      easing: Easing.linear,
    }).start(() => this.spin())
  }

  render () {
    //映射 0-1的值 映射 成 0 - 360 度
    const spin = this.spinValue.interpolate({
      inputRange: [0, 1],//输入值
      outputRange: ['0deg', '360deg'], //输出值
    })
    return (
      <Animated.Image style={[styles.styleCircle, {transform: [{rotate: spin}]}]} source={images.loadingLogo}/>
    )
  }
}

const styles = StyleSheet.create({
  styleCircle: {
    width: circleSize,
    height: circleSize,
  },
})
