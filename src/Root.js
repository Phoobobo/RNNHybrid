/**
 * Created by fubaolin on 2018/5/2.
 */
import React from 'react';
import {
    View,
    Button,
    Text,
    Platform,
    NativeModules,
} from 'react-native';
import { TabNavigator, StackNavigator } from 'react-navigation';

const RN2NHelper = NativeModules.RN2N;

class HomeDetailsScreen extends React.Component {
    render() {
        return (
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                <Text>Details!</Text>
            </View>
        );
    }
}

class SettingDetailsScreen extends React.Component {
    render() {
        return (
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                <Button
                    title="Go to Native Activity"
                    onPress={() => {
                        const options = {};
                        RN2NHelper.launchNative('com.rnnhybrid.SecondActivity', options)
                    }}
                />
            </View>
        );
    }
}

class HomeScreen extends React.Component {
    render() {
        return (
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                { /* other code from before here */ }
                <Button
                    title="Go to Details"
                    onPress={() => this.props.navigation.navigate('Details')}
                />
            </View>
        );
    }
}

class SettingsScreen extends React.Component {
    render() {
        return (
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                { /* other code from before here */ }
                <Button
                    title="Go to Details"
                    onPress={() => this.props.navigation.navigate('Details')}
                />
            </View>
        );
    }
}

const HomeStack = StackNavigator({
    Home: { screen: HomeScreen },
    Details: {
        screen: HomeDetailsScreen,
        path: 'home/detail',
    },
});

const SettingsStack = StackNavigator({
    Settings: { screen: SettingsScreen },
    Details: {
        screen: SettingDetailsScreen,
        path: 'setting/detail',
    },
});

const prefix = Platform.OS === 'android' ? 'rn://rn/' : 'rn://';

const App = TabNavigator(
    {
        Home: { screen: HomeStack },
        Settings: { screen: SettingsStack },
    },
    {
        tabBarPosition: 'bottom',
    }
);

export default () => <App uriPrefix={prefix} />;