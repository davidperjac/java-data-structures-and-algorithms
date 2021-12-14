package huffman;

public class HuffmanInfo {
    private String text;
    private int frequency;
    private int bit;

    public HuffmanInfo(String text, int frequency) {
        this.text = text;
        this.frequency = frequency;
        this.bit = -1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    @Override
    public String toString() {
        return "HuffmanInfo [" + "text=" + text + ", frequency=" + frequency + ", bit=" + bit + ']';
    }
}
