import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Pair<K, V> {
    private K key;

    private V value;

    Pair(K k, V v) {
        this.key = k;
        this.value = v;
    }

    K getKey() {
        return this.key;
    }

    V getValue() {
        return this.value;
    }

    // ueberschreiben der Object-equals-Methode
    public boolean equals(Object obj) {
        // 2 Pair-Objekte sind gleich, wenn ihre Schluessel
        // gleich sind
        Pair<K, V> pair = (Pair<K, V>) obj;
        return this.key.equals(pair.key);
    }
    
    // ueberschreiben der Object-hashCode-Methode
    public int hashCode() {
        return this.key.hashCode();
    }
}

public class Map<K, V> {

    private Array<Pair<K, V>> entries;

    public Map() {
        this.entries = new Array<Pair<K, V>>();
    }

    public void put(K key, V value) {
        this.remove(key); // vorsorglich loeschen
        this.entries.add(new Pair<K, V>(key, value));
    }

    public V get(K key) {
        for (int i = 0; i < this.entries.size(); i++) {
            Pair<K, V> pair = this.entries.get(i);
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        this.entries.remove(new Pair<K, V>(key, null));
    }

    public boolean contains(K key) {
        return this.entries.contains(new Pair<K, V>(key, null));
    }
}