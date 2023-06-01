import { UserAuth } from "./UserAuth.interface";

export interface UserProfile extends UserAuth{
    name: string;
    apellidos: string;
    telephoneNumber: string;
    email: string;
}