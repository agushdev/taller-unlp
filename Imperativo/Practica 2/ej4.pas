{
4.- Realizar un programa que lea números y que utilice un módulo recursivo que escriba el
equivalente en binario de un número decimal. El programa termina cuando el usuario ingresa
el número 0 (cero).

Ayuda: Analizando las posibilidades encontramos que: Binario (N) es N si el valor es menor a 2.
¿Cómo obtenemos los dígitos que componen al número? ¿Cómo achicamos el número para la
próxima llamada recursiva? Ejemplo: si se ingresa 23, el programa debe mostrar: 10111.

}

program cuachi;

    procedure binario(num:integer);
    begin
        if (num > 1) then binario(num div 2);
        write(num mod 2);
    end;

    procedure conversion;
    var
        num:integer;
    begin
        writeln('Ingrese un num (con 0 termina):');
        readln(num);
        if (num <> 0) then begin
            write('El resultado es: ');
            binario(num);
            writeln;
            conversion;
        end else writeln('Se termino la jodita');
    end;

begin
    conversion;
end.
