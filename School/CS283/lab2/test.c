#include<stdio.h>

main()
{
	int Fahrenheit;

	for (Fahrenheit = 0; Fahrenheit <= 300; Fahrenheit = Fahrenheit + 20)
		printf("%3d %06.3f\n", Fahrenheit, (5.0/9.0)*(Fahrenheit-32));
}
