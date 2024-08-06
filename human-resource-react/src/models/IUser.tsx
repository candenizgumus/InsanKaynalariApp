export interface IUser{
    createdAt:Date ;
    updatedAt:Date ;
    status:string ;
    id:number ;
    companyId:number ;
    authId:number ;
    managerId:number ;
    email:string ;
    name:string ;
    surname:string ;
    phone:string ;
    birthDate:Date  ;
    hireDate:Date ;
    photo:string ;
    userType:string ;
    position:string ;
    sector:string ;
    location:string ;
    employeeType:string;
    subscriptionType:string;
    subscriptionStartDate:Date;
    subscriptionEndDate:Date;
}