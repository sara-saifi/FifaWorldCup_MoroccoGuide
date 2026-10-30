import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import Login from './ecrans/Login';
import Acceuil from './ecrans/Acceuil';
import Inscription from './ecrans/Inscription';
import Hotel from './ecrans/Hotel';
import Restaurant from './ecrans/Restaurant';
import Matchs from './ecrans/Matchs';
import Reservation from './ecrans/Reservation';
import Profile from './ecrans/Profile';

export default function App() {
  const Stack = createNativeStackNavigator();

  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Login">
        <Stack.Screen name="Login" component={Login} />
        <Stack.Screen name="Inscription" component={Inscription} />
        <Stack.Screen name="Accueil" component={ Acceuil} />
        <Stack.Screen name="Hotel" component={Hotel} />
        <Stack.Screen name="Restaurant" component={Restaurant} />
        <Stack.Screen name="Matchs" component={Matchs} />
        <Stack.Screen name="Reservation" component={Reservation} />
        <Stack.Screen name="Profile" component={Profile} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}