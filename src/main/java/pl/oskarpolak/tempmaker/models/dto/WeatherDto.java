package pl.oskarpolak.tempmaker.models.dto;

import com.google.gson.annotations.SerializedName;

public class WeatherDto {
    @SerializedName("main")
    private TempDto tempDto;

    public TempDto getTempDto() {
        return tempDto;
    }

    public static class TempDto {
        private double temp;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }
}
