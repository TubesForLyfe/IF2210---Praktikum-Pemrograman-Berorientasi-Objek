import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class OrchidDataAvgProcessor implements Runnable {
    // Tambahkan atribut sesuai kebutuhan
    private OrchidMeanDatum meanDatum;
    private String rawDataFilename;

    public OrchidDataAvgProcessor(OrchidMeanDatum meanDatum, String rawDataFilename) {
        // Konstruktor
        this.meanDatum = meanDatum;
        this.rawDataFilename = rawDataFilename;
    }

    @Override
    public void run() {
        // Menghitung rata-rata dari data yang dibaca dengan CSVReader, lalu update
        // meanDatum dengan rata-rata dari setiap aspek data

        // Apabila muncul IOException, maka hasil pembacaan data adalah kosong
        // dan meanDatum tidak di-update (tidak di throw lagi)
        try {
            CSVReader reader = new CSVReader(this.rawDataFilename, ",");
            reader.setSkipHeader(true);
            List<String[]> rows = reader.read();
            // Untuk setiap x dan y, tambahkan tree ke Chunk
            // Jika ada IOException pada saat membaca reader, catch Exception
            // tidak ada tree yang ditambahkan pada Chunk (tidak dithrow lagi)
            float meanPetalLength = 0;
            float meanPetalWidth = 0;
            float meanStemLength = 0;
            int count = 0;
            for (String[] row : rows) {
                count++;
                meanPetalLength += Double.valueOf(row[0]);
                meanPetalWidth += Double.valueOf(row[1]);
                meanStemLength += Double.valueOf(row[2]);
            }
            meanDatum.setMean(meanPetalLength/count, meanPetalWidth/count, meanStemLength/count);
        } catch(Exception e) {
            // pass
        }
    }
}