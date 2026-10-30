import React from 'react';
import { View, Button, Alert, StyleSheet } from 'react-native';
import axios from 'axios';

export default function Reservation({ route, navigation }) {
  const { userId, restaurantId, hotelId, matchId } = route.params;

  const handleReservation = () => {
    axios.post('http://10.0.2.2:8080/api/reservations', {
      utilisateur: { id: Number(userId) },
      restaurant: restaurantId ? { id_restaurant: Number(restaurantId) } : null,
      hotel: hotelId ? { id_hotel: Number(hotelId) } : null,
      match: matchId ? { id_match: Number(matchId) } : null
    })
    .then(() => {
      Alert.alert('Succès', 'Réservation effectuée');
      navigation.goBack();
    })
    .catch(err => {
      console.log(err);
      Alert.alert('Erreur', 'Impossible de réserver');//disabled={false}
    });
  };

  return (
    <View style={styles.container}>
      <Button title="Confirmer la réservation" color="#B22222" onPress={handleReservation}  />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20, flex: 1, justifyContent: 'center', backgroundColor: '#FDF5E6' }
});
