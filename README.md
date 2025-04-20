# SiguriaDhenaveGR6
---------------------------------------------------
Mjetet e Shifrimit – Implementim në Java
Ky projekt përfshin implementimin e dy algoritmeve klasike të shifrimit të ndërtuara në gjuhën Java:

Shifrimi me Permutim
Shifrimi Bidil (Atbash)

Programi ju lejon të zgjidhni nëse dëshironi të shifroni apo deshifroni një mesazh duke përdorur njërin nga këto dy algoritme.

Hapat për të Ekzekutuar:
Ruaje secilin algoritëm në një skedar të veçantë .java:

PermutationCipher.java
BidilCipher.java

Hap terminalin ose IDE në dosjen ku ndodhen skedarët.
Kompilo programin:
---------------------------------------------
 1. Shifrimi me Permutim
 Përshkrimi
Shifrimi me Permutim është një cipher me transpozim bllokesh, që riorganizon karakteret brenda blloqeve me madhësi të barabartë sipas një çelësi të caktuar.

Nëse gjatësia e mesazhit nuk është e pjesëtueshme me madhësinë e çelësit, mesazhi plotësohet me X.

Deshifrimi rikthen renditjen duke përdorur çelësin invers.

 Shembull i Çelësit
Për çelësin {2, 0, 1} dhe mesazhin "HELLO":

Mesazhi bëhet "HELLOX" (pasi shtohet një X)

Blloqet:

"HEL" → riorganizohet si "LHE"
"LOX" → riorganizohet si "XLO"
Mesazhi i shifruar: "LHEXLO"

----------------------------------------------------------------
2. Shifrimi Bidil (Atbash)
Përshkrimi
Shifrimi Bidil është një cipher me zëvendësim monoalfabetik, ku çdo shkronjë zëvendësohet me pasqyrën e saj në alfabet.

A ↔ Z, B ↔ Y, ..., M ↔ N

Përdoret e njëjta logjikë për shifrim dhe deshifrim

Simbolet, numrat dhe hapësirat nuk ndryshohen
