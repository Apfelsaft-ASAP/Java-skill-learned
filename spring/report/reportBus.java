package spring.report;

class Vehicle {
    int maxPassenger;
    int actPassenger;
    int price;
    int vehicleID;
    int fuel;
    int actSpeed;
    String status;
    String destination;

    int toDestination;
    int perDestination;

    public Vehicle(int maxPassenger, int price, int fuel) {
        this.vehicleID = generatebusID();
        this.status = "운행 중";
        this.maxPassenger = maxPassenger;
        this.price = price;
        this.fuel = fuel;
        this.actPassenger = 0;
        this.actSpeed = 0;
    }

    int generatebusID() {
        return (int)(Math.random() * 9000)+1000;
    }

    void busStatus() {
        if(this.status.equals("운행 중")) {
            System.out.println("버스번호: "+this.vehicleID);
        }else {
            System.out.println("버스번호: "+this.vehicleID);
            System.out.println("차량이 차고지에 있습니다");
        }
    }

    void taxiStatus() {
        if(this.status.equals("운행 중")) {
            System.out.println("택시번호: "+this.vehicleID);
        }else {
            System.out.println("택시번호: "+this.vehicleID);
            System.out.println("차량이 차고지에 있습니다");
        }
    }

    void changeStatus() {
        if(this.fuel < 10) {
            System.out.println("주유가 필요하다.");
            this.actPassenger = 0;
            this.status = "차고지 행";
        }else if(status.equals("차고지 행")){
            this.status = "운행 중";
        }
        else {
            this.actPassenger = 0;
            this.status = "차고지 행";
        }
    }

    void addPassenger(int Passenger){
        if(status.equals("운행 중")&&actPassenger < maxPassenger) {
            if (this.actPassenger + Passenger <= this.maxPassenger) {
                this.actPassenger += Passenger;
                System.out.println("탑승 승객은 "+actPassenger+"명 입니다.");
                int empty = maxPassenger-actPassenger;
                System.out.println("잔여 좌석 수는: "+empty);
                System.out.println("총 요금: "+ price*Passenger);
            }else {
                System.out.println("최대 승객 수 초과");
            }
        }else if(status.equals("운행 중")&&actPassenger > maxPassenger){
            System.out.println("만석 입니다.");
        }else{
            System.out.println("차량이 차고지에 있습니다.");
        }
    }

    void changeSpeed(int speed){
        if(fuel>=10) {
            actSpeed += speed;
            System.out.println("현재 속도: "+actSpeed);
        }else{
            System.out.print("주유량을 확인해 주세요.");
        }
    }

    void useFuel(int addfuel) {
        if (status.equals("차고지 행")) {
            fuel += addfuel;
            System.out.println("차량 현황: "+status);
            System.out.println("현재 연료량: " + fuel);
        }else if(fuel + addfuel < 10) {
            fuel += addfuel;
            System.out.println("현재 연료량: " + fuel);
            System.out.println("주유가 필요합니다.");
            System.out.println("차량 현황: "+status);
        }
        else {
            fuel += addfuel;
            System.out.println("현재 연료량: " + fuel);
        }
    }

    int getmaxPassenger(){
        return maxPassenger;
    }

    void setmaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    int getactPassenger(){
        return actPassenger;
    }

    void setactPassenger(int Passenger){
        this.actPassenger = actPassenger;
    }

    int getactSpeed(){
        return actSpeed;
    }

    void setactSpeed(int actSpeed){
        this.actSpeed = actSpeed;
    }

    int getFuel(){
        return fuel;
    }

    void setFuel(int fuel) {
        this.fuel = fuel;
    }

    String getStatus(){
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }
}