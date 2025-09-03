// INCOMPLETO

{
Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
septiembre de 2025. De cada película se conoce: código de película, código de género (1:
acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y
puntaje promedio otorgado por las críticas.

Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:

a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.

b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje
obtenido entre todas las críticas, a partir de la estructura generada en a)..

c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos
métodos vistos en la teoría.

d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje,
del vector obtenido en el punto c).
}

program pelis;

const
	generos=8;
	fin=-1;
type
	rangoGeneros= 1..generos;
	
	pelicula= record
		codPeli:integer;
		codGenero:rangoGeneros;
		puntajePromedio:real;
	end;
	
	lista= ^nodo;
	
	nodo= record
		elem: pelicula;
		sig: lista;
	end;
	
	vecGenero= array[rangoGeneros] of lista;

	maxPuntaje= record
		codPeli: integer;
		puntajePromedio: real;
	end;

	vecMayorPuntaje= array[rangoGeneros] of maxPuntaje;
	
procedure leerPeli(var p:pelicula);
begin
	write ('Ingrese el codigo de pelicula: (-1 para finalizar)');
	readln(p.codPeli);
	if (p.codPeli <> fin) then begin
		write ('Ingrese el codigo de genero (entre 1 y 8): ');
		readln (p.codGenero); 
		write ('Ingrese el puntaje: (entre 0.0 y 10)'); 
		readln (p.puntajePromedio); 
	end;
end;

procedure agregarAtras(var l, ult:lista; elem:pelicula);
var nue:lista;
begin
	new(nue);
	nue^.elem:= elem;
	nue^.sig:= nil;
	if (l = nil) then
		l:= nue
	else
		ult^.sig:= nue;
	ult:=nue;
end;

procedure cargarVec(var vG:vecGenero);
var 
	p:pelicula;
	ult: array[rangoGeneros] of pelicula;
begin
	leerPeli(p);
	while (p.codPeli <> fin)do begin
		agregarAtras(vG[p.codGenero],ult[p.codGenero],p);
		leerPeli(p);
	end;
end;

procedure inicializarVec(var vG:vecGenero; var vM:vecMayorPuntaje);
var 
	i:rangoGeneros;
begin
	for i:=1 to generos do begin
	  vG[i]:=nil;
	  vM[i]:=0;
	end;
end;

procedure cargarVecGenero(var v:vecGenero; var vP:vecMayorPuntaje);
var
	i: rangoGeneros;
	puntajeMax: real;
	codPuntajeMax: integer;
	l:lista;
begin
	for i:=1 to generos do begin
		l:= v[i];
		puntajeMax:= -1; {Puntaje minimo}
		codPuntajeMax:= 0; {Codigo de pelicula minimo}
		while (l <> nil) do begin
			if (l^.elem.puntajePromedio > puntajeMax) then begin
				puntajeMax:= l^.elem.puntajePromedio;
				codPuntajeMax:= l^.elem.codPeli;
			end;
			l:= l^.sig;
		end;
		vP[i]:= codPuntajeMax;
	end;
end;

procedure ordenarVec(var v:vecMayorPuntaje);
var
	i, j, actual: integer;
begin
	for i:=2 to generos do begin
		actual:= v[i];
		j:= i-1;
		while (j > 0) and (v[j].puntajePromedio < actual.puntajePromedio) do begin
			v[j+1]:= v[j];
			j:= j-1;
		end;
		v[j+1]:= actual;
	end;
end;

var
	v:vecGenero; vM:vecMayorPuntaje;
begin
	inicializarVec(v,vM);
	
	cargarVec(v);
	cargarVecGenero(v, vM);
	ordenarVec(vM);
	
	writeln ('Cod peli con mayor puntaje:', vM[generos]);
	writeln ('Cod de peli con menor puntaje:', vM [1]);
end.
