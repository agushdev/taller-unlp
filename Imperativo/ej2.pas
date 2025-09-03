{
- El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de
las expensas de dichas oficinas.

Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:

a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina
se ingresa el código de identificación, DNI del propietario y valor de la expensa. La lectura
finaliza cuando se ingresa el código de identificación -1, el cual no se procesa.

b. Ordene el vector, aplicando el método de inserción, por código de identificación de la
oficina.

c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina.
}

program oficinas;
const
	dimF = 300;
	fin = -1;
type
	rangoOficinas = 0..dimF;
	
	infoOficina = record
		codId: integer;
		dni: integer;
		valor: real;
	end;
	
	vecOficinas = array[rangoOficinas] of infoOficina;
	
procedure leerInfo(var i: infoOficina); 
begin
	readln(i.codId);
	if (i.codId <> fin) then begin
		readln(i.dni);
		readln(i.valor);
	end;
end;


procedure insertarElemento(var v: vecOficinas; var dimL: rangoOficinas; i: infoOficina); 
begin
	dimL:= dimL + 1;
	v[dimL] := i;
end;


procedure cargarVec(var v: vecOficinas; var dimL: rangoOficinas);
var i: infoOficina;
begin
	leerInfo(i);
	while (i.codId <> fin) do begin
		insertarElemento(v, dimL, i);
		leerInfo(i);
	end;
end;

procedure ordenarSeleccion(var v: vecOficinas; dimL: rangoOficinas);
var min, pos, i, j:integer;
begin
	for i:=1 to (dimL-1) do begin
		pos:= i;
		
		for j:=i+1 to dimL do begin
			if (v[j].codId < v[pos].codId) then pos:= j;
		end;
		
		min:= v[pos].codId;
		v[pos].codId:= v[i].codId;
		v[i].codId:= min;
	end;
end;

procedure ordenarInsercion(var v: vecOficinas; dimL: rangoOficinas);
var act, i, j: integer;
begin
	for i:=2 to dimL do begin
		act:= v[i].codId;
		j:= i - 1;
		while(j<>0) and (v[j].codId > act) do begin
			v[j+1].codId:= v[j].codId;
			j:= j-1;
		end;
		v[j+1].codId:= act;
	end;
end;

var
	v: vecOficinas;
	dimL: rangoOficinas;
begin
	dimL:= 0;
	cargarVec(v, dimL);
end.
