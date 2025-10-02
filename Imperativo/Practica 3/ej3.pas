{
3. Implementar un programa que contenga:

a. Un módulo que lea información de los finales rendidos por los alumnos de la Facultad de
Informática y los almacene en una estructura de datos. La información que se lee es legajo,
código de materia, fecha y nota. La lectura de los alumnos finaliza con legajo 0. La estructura
generada debe ser eficiente para la búsqueda por número de legajo y para cada alumno deben
guardarse los finales que rindió en una lista.

b. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con
legajo impar.

c. Un módulo que reciba la estructura generada en a. e informe, para cada alumno, su legajo y
su cantidad de finales aprobados (nota mayor o igual a 4).

d. Un módulo que reciba la estructura generada en a. y un valor real. Este módulo debe
retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.
}

program a;

const
	fin=0;

type
	rangoNota=1..10;
	rangoDia=1..31;
	rangoMes=1..12;
	rangoAnio=2000..2025;
	
	infoFecha= record
		dia:rangoDia;
		mes:rangoMes;
		anio:rangoAnio;
	end;
	
	finales=record
		codMateria:integer;
		fecha:infoFecha;
		nota:rangoNota;
	end;
	
	lista= ^nodo;
	nodo= record
		elem:finales;
		sig:lista;
	end;
	
	alumno= record
		legajo:integer;
		finales:lista;
	end;
	
	arbol= ^nodoArbol;
	nodoArbol= record
		elem: alumno;
		hi: arbol;
		hd: arbol;
	end;

	
	procedure leerFinal(var f:finales);
	begin
	    f.codMateria:= random(50) + 1;
	    f.fecha.dia:= random(31) + 1;
	    f.fecha.mes:= random(12) + 1;
	    f.fecha.anio:=random(25) + 2000;
	    f.nota:= random(10) + 1;
	end;
	
  procedure agregarAdelante(var l: lista; f: finales);
	var
		nue: lista;
	begin
		new(nue);
		nue^.elem := f;
		nue^.sig := l;
		l := nue;
	end;
  
    procedure leerAlumno(var a:alumno);
    var 
        i, cant: integer;
        f: finales;
    begin
        write('Ingrese legajo (0 para finalizar): ');
        readln(a.legajo);
        if (a.legajo <> fin) then begin
            a.finales := nil;
            write('Ingrese cantidad de finales rendidos: ');
            readln(cant);
            for i:=1 to cant do begin
                leerFinal(f);
                agregarAdelante(a.finales, f);
            end;
        end;
    end;
	
	procedure agregarArbol(var a:arbol; alu:alumno);
	begin
		if (a=nil) then begin // Caso base
			new(a);
			a^.elem:=alu;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else if (alu.legajo < a^.elem.legajo) then
            agregarArbol(a^.hi, alu)
        else if (alu.legajo > a^.elem.legajo) then
            agregarArbol(a^.hd, alu)
        else
            writeln('Legajo duplicado: ', alu.legajo, ' ');
	end;
	
	procedure cargar(var a:arbol);
	var alu:alumno; 
	begin
		leerAlumno(alu);
		if (alu.legajo <> fin) then begin
			agregarArbol(a, alu);
			cargar(a);
		end;
	end;
	
  { b. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con legajo impar. }
  
    function cantImpar(a:arbol):integer;
    begin
        if (a=nil) then cantImpar:= 0
        else begin
            cantImpar := cantImpar(a^.hi) + cantImpar(a^.hd);
            if (a^.elem.legajo mod 2 <> 0) then
                cantImpar := cantImpar + 1;
        end;
    end;
  
    {c. Un módulo que reciba la estructura generada en a. e informe, para cada alumno, su legajo y
    su cantidad de finales aprobados (nota mayor o igual a 4).}

    function cantAprobados(l:lista):integer;
    var cant:integer;
    begin
        cant:= 0;
        while (l <> nil) do begin
            if (l^.elem.nota >= 4) then cant:= cant + 1;
            l:= l^.sig;
        end;
        cantAprobados:= cant;
    end;

    procedure informarAprobados(a:arbol);
    begin
        if (a <> nil) then begin
            informarAprobados(a^.hi);
            writeln('Legajo: ', a^.elem.legajo, ' - Finales aprobados: ', cantAprobados(a^.elem.finales));
            informarAprobados(a^.hd);
        end;
    end;

    {d. Un módulo que reciba la estructura generada en a. y un valor real. Este módulo debe
    retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.}

    function calcularPromedio(l:lista): real;
    var sumaTotal, finales:integer;
    begin
        sumaTotal:=0; finales:=0;
        while (l <> nil) do begin
            sumaTotal:= sumaTotal + l^.elem.nota;
            finales:= finales + 1;
            l:= l^.sig;
        end;

        if (finales > 0) then calcularPromedio:= sumaTotal / finales
        else calcularPromedio:= 0;
    end;

    procedure superaPromedio(a:arbol; num:real);
    var promedio: real;
    begin
        if (a <> nil) then begin
            superaPromedio(a^.hi, num);
            promedio:= calcularPromedio(a^.elem.finales);
            if (promedio > num) then writeln('Legajo: ', a^.elem.legajo, '  Promedio: ', promedio:0:2);
            superaPromedio(a^.hd, num);
        end;
    end;

var
	ar:arbol;
    valor: real;
begin
	randomize;
	ar:=nil;
	cargar(ar);

    writeln('Cant impares: ',cantImpar(ar));

    informarAprobados(ar);

    write('Ingrese el promedio minimo a superar: ');
    readln(valor);
    superaPromedio(ar, valor);
end.
