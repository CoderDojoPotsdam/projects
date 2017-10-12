import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class Int {

    int wert;

    Int(int w) { 
      this.wert = w; 
    }

    Int(Int obj) { 
      this.wert = obj.wert; 
    }

    protected Object clone() { 
      return new Int(this); 
    }

    public String toString() { 
      return String.valueOf(this.wert); 
    }

    public boolean equals(Object obj) { 
      return this.wert == ((Int)obj).wert; 
    }

    int getWert() { 
      return this.wert; 
    }
}
