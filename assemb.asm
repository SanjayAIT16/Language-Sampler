section .data
    num db 10  ; Change this value to the number you want to check

section .text
    global _start

_start:
    mov al, [num]  ; Move the value of num into the AL register
    test al, 1     ; Test the least significant bit (LSB) of AL
    jz even        ; Jump to even label if LSB is 0
    ; If LSB is 1 (odd), print "Odd" and exit
    mov edx, odd_msg
    call print
    jmp exit

even:
    ; If LSB is 0 (even), print "Even" and exit
    mov edx, even_msg
    call print

exit:
    ; Exit the program
    mov eax, 1     ; syscall number for exit
    xor ebx, ebx   ; exit code 0
    int 0x80       ; call kernel

print:
    ; Print the message stored in EDX
    mov eax, 4     ; syscall number for sys_write
    mov ebx, 1     ; file descriptor 1 (stdout)
    mov ecx, edx   ; message address
    mov edx, len   ; message length
    int 0x80       ; call kernel
    ret

section .data
    odd_msg db "Odd", 10  ; Newline character at the end
    even_msg db "Even", 10
    len equ $ - odd_msg     ; Length of the messages
