package MED_Check.genericId;

public class GenericId {
    public static Long departamentId = 0L;
    public static Long doctorId = 0L;
    public static Long hospitalId = 0L;
    public static Long petientId = 0L;
    public static long genericDepartamentId(){
        return ++departamentId;
    }
    public static long genericDoctorId(){
        return ++doctorId;
    }
    public static long genericHospitalId(){
        return ++hospitalId;
    }
    public static long genericPatientId(){
        return ++petientId;
    }
}
