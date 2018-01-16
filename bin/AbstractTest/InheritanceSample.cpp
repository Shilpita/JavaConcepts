//base class
class Person
{
public:
	Person(string inputName, int inputYear, string inputphnnum)
	{
		name = inputName;
		dobYear = inputYear;
		phnNumber = inputphnnum
	}
	string name;
	int dobYear;
	void print()
	{
		cout << "Last name: " << name << endl;
		cout << "Year of birth: " << dobYear << endl;
	}
protected:
	string phnNumber;

    void dialed()
    {
    	cout << "last dialled number: " << phnNumber << endl;
    }

};