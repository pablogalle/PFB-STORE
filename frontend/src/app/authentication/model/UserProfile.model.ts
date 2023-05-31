export class UserProfile {
    private username: string;
    private name: string;
    private surname: string;
    private phoneNumber: string;
    private email: string;
    private password: string;

    constructor(
        username: string,
        name: string,
        surname: string,
        phoneNumber: string,
        email: string,
        password: string
    ) {
        this.username = username
        this.name = name
        this.surname = surname
        this.phoneNumber = phoneNumber
        this.email = email
        this.password = password
    }

    public getUsername(): string {
        return this.username;
    }

    public setUsername(username: string): void {
        this.username = username;
    }

    public getName(): string {
        return this.name;
    }

    public setName(name: string): void {
        this.name = name;
    }

    public getSurname(): string {
        return this.surname;
    }

    public setSurname(surname: string): void {
        this.surname = surname;
    }

    public getPhoneNumber(): string {
        return this.phoneNumber;
    }

    public setPhoneNumber(phoneNumber: string): void {
        this.phoneNumber = phoneNumber;
    }

    public getEmail(): string {
        return this.email;
    }

    public setEmail(email: string): void {
        this.email = email;
    }

    public getPassword(): string {
        return this.password;
    }

    public setPassword(password: string): void {
        this.password = password;
    }
}