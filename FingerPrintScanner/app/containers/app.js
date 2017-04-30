import React, {Component} from 'react'
import {
	View,
	StyleSheet,
} from 'react-native'

import FingerPrint from '../components/FingerPrint'

class App extends Component {
	render(){
		return(
			<View style={styles.MainContainer}>
				<FingerPrint/>
			</View>
		)
	}
}

const styles = StyleSheet.create({
	MainContainer: {
		flex:1,
	}
})

export default App;