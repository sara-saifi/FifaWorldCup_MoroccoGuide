import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, TouchableOpacity, StyleSheet } from 'react-native';
import axios from 'axios';

export default function Matchs({ navigation, route }) {
  const { userId } = route.params;
  const [matchs, setMatchs] = useState([]);

  useEffect(() => {
    axios.get('http://10.0.2.2:8080/api/matchs')
      .then(res => setMatchs(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <View style={{ padding: 20 }}>
      <FlatList
        data={matchs}
        keyExtractor={item => item.id_match.toString()}
        renderItem={({ item }) => (
          <View style={styles.card}>
            <Text style={styles.title}>{item.equipe1} vs {item.equipe2}</Text>
            <Text>Date: {item.date}</Text>
            <Text>Stade: {item.stade}</Text>
            <TouchableOpacity
              style={styles.button}
              onPress={() =>
                navigation.navigate('Reservation', {
                  userId,
                  matchId: item.id_match
                })
              }
            >
              <Text style={styles.buttonText}>Réserver</Text>
            </TouchableOpacity>
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  card: { borderWidth: 1, padding: 15, marginBottom: 15, borderRadius: 10 },
  title: { fontSize: 18, fontWeight: 'bold' },
  button: { marginTop: 10, backgroundColor: '#1E90FF', padding: 10, borderRadius: 8, alignItems: 'center' },
  buttonText: { color: '#fff', fontWeight: 'bold' }
});
