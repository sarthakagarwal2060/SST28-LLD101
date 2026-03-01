public class ClassroomController {

    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) {
        this.reg = reg;
    }

    public void startClass() {

        reg.get(PowerDevice.class).powerOn();
        reg.get(InputConnectable.class).connectInput("HDMI-1");

        reg.get(BrightnessControl.class).setBrightness(60);

        reg.get(TemperatureControl.class).setTemperatureC(24);

        int present = reg.get(AttendanceScanning.class).scanAttendance();

        System.out.println("Attendance scanned: present=" + present);
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");

        reg.get(Projector.class).powerOff();
        reg.get(LightsPanel.class).powerOff();
        reg.get(AirConditioner.class).powerOff();
    }
}