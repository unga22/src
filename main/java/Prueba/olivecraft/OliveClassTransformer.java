package Prueba.olivecraft;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;

import java.util.Iterator;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class OliveClassTransformer implements IClassTransformer
{
    public byte[] transform(String arg0, String arg1, byte[] arg2) {
        if (arg0.equals("net.minecraft.inventory.InventoryCrafting")) {
            arg2 = patchInventoryCrafting(arg2, false);
        } else if (arg0.equals("yq")) {
        	arg2 = patchInventoryCrafting(arg2, true);
    	} else if (arg0.equals("net.minecraft.inventory.SlotCrafting")) {
        	arg2 = patchSlotCrafting(arg2, false);
        } else if (arg0.equals("zj")) {
        	arg2 = patchSlotCrafting(arg2, true);
        }

        return arg2;
    }
    
    private byte[] patchInventoryCrafting(byte[] bytes, boolean obf) {
    	String method, desc;
    	String fieldClass, field, fieldDesc;
    	String invokeClass, invokeMethod, invokeDesc;
    	
    	if (obf) {
    		method = "e";
    		desc = "()V";
    		fieldClass = "yq";
    		field = "c";
    		fieldDesc = "Lye;";
    		invokeClass = "ye";
    		invokeMethod = "a";
    		invokeDesc = "(Lpo;)V";
    	} else {
    		method = "markDirty";
    		desc = "()V";
    		fieldClass = "net/minecraft/inventory/InventoryCrafting";
    		field = "eventHandler";
    		fieldDesc = "Lnet/minecraft/inventory/Container;";
    		invokeClass = "net/minecraft/inventory/Container";
    		invokeMethod = "onCraftMatrixChanged";
    		invokeDesc = "(Lnet/minecraft/inventory/IInventory;)V";
    	}
    	ClassNode classNode = new ClassNode();
    	ClassReader classReader = new ClassReader(bytes);
    	classReader.accept(classNode, 0);
    	
    	Iterator<MethodNode> methods = classNode.methods.iterator();
    	while(methods.hasNext()) {
    		MethodNode m = methods.next();
    		if (m.name.equals(method) && m.desc.equals(desc)) {
    			InsnList inst = new InsnList();
    			inst.add(new VarInsnNode(ALOAD, 0));
    			inst.add(new FieldInsnNode(GETFIELD, fieldClass, field, fieldDesc));
    			inst.add(new VarInsnNode(ALOAD, 0));
    			inst.add(new MethodInsnNode(INVOKEVIRTUAL, invokeClass, invokeMethod, invokeDesc));
    			m.instructions.insert(inst);
    		}
    	}
    	
    	ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
    	classNode.accept(writer);
    	return writer.toByteArray();
    }
    
    private byte[] patchSlotCrafting(byte[] bytes, boolean obf) {
    	String method, desc;
    	String findInvokeMethod, findInvokeDesc;
    	String fieldClass, field, fieldDesc;
    	String invokeDesc;
    	String findInvokeMethod_2, findInvokeDesc_2;
    	String invokeDesc_2;
    	
		if (obf) {
    		method = "a";
    		desc = "(Lxl;Labp;)V";
    		findInvokeMethod = "b";
    		findInvokeDesc = "(Labp;)V";
    		fieldClass = "zj";
    		field = "a";
    		fieldDesc = "Lpo;";
    		invokeDesc = "(Lxl;Lpo;)Ljoserichi/olivecraft/common/item/crafting/ICuantityRecipe;";
    		findInvokeMethod_2 = "a";
    		findInvokeDesc_2 = "(II)Labp;";
    		invokeDesc_2 = "(Ljoserichi/olivecraft/common/item/crafting/ICuantityRecipe;Lpo;I)V";
    	} else {
    		method = "onPickupFromSlot";
    		desc = "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/item/ItemStack;)V";
    		findInvokeMethod = "onCrafting";
    		findInvokeDesc = "(Lnet/minecraft/item/ItemStack;)V";
    		fieldClass = "net/minecraft/inventory/SlotCrafting";
    		field = "craftMatrix";
    		fieldDesc = "Lnet/minecraft/inventory/IInventory;";
    		invokeDesc = "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/inventory/IInventory;)Ljoserichi/olivecraft/common/item/crafting/ICuantityRecipe;";
    		findInvokeMethod_2 = "decrStackSize";
    		findInvokeDesc_2 = "(II)Lnet/minecraft/item/ItemStack;";
    		invokeDesc_2 = "(Ljoserichi/olivecraft/common/item/crafting/ICuantityRecipe;Lnet/minecraft/inventory/IInventory;I)V";
    	}
    	ClassNode classNode = new ClassNode();
    	ClassReader classReader = new ClassReader(bytes);
    	classReader.accept(classNode, 0);
    	
    	Iterator<MethodNode> methods = classNode.methods.iterator();
    	while(methods.hasNext()) {
    		MethodNode m = methods.next();
    		if (m.name.equals(method) && m.desc.equals(desc)) {    			
    			Iterator<AbstractInsnNode> iter = m.instructions.iterator();
    			AbstractInsnNode currentNode;
    			while (iter.hasNext()) {
    				currentNode = iter.next();
    				if (currentNode.getOpcode() == INVOKEVIRTUAL && ((MethodInsnNode) currentNode).name.equals(findInvokeMethod) && ((MethodInsnNode) currentNode).desc.equals(findInvokeDesc)) {
    					InsnList inst = new InsnList();
    					inst.add(new VarInsnNode(ALOAD, 1));
    					inst.add(new VarInsnNode(ALOAD, 0));
    					inst.add(new FieldInsnNode(GETFIELD, fieldClass, field, fieldDesc));
    					inst.add(new MethodInsnNode(INVOKESTATIC, "joserichi/olivecraft/common/core/SlotCraftingHelper", "cuantityRecipe", invokeDesc ));
    					inst.add(new VarInsnNode(ASTORE, 6));
    					m.instructions.insert(currentNode, inst);
    				}
    				
    				if (currentNode.getOpcode() == INVOKEINTERFACE && ((MethodInsnNode) currentNode).name.equals(findInvokeMethod_2) && ((MethodInsnNode) currentNode).desc.equals(findInvokeDesc_2)) {
    					int last = m.instructions.indexOf(currentNode) + 1;
    					InsnList inst = new InsnList();
    					inst.add(new VarInsnNode(ALOAD, 6));
    					inst.add(new VarInsnNode(ALOAD, 0));
    					inst.add(new FieldInsnNode(GETFIELD, fieldClass, field, fieldDesc));
    					inst.add(new VarInsnNode(ILOAD, 3));
    					inst.add(new MethodInsnNode(INVOKESTATIC, "joserichi/olivecraft/common/core/SlotCraftingHelper", "decreaseStack", invokeDesc_2));
    					m.instructions.insert(m.instructions.get(last), inst);
    					for (int i = 0; i < 6; i++) {
    						m.instructions.remove(m.instructions.get(last - i));
    					}
    				}
    			}
    		}
    	}
    	
    	ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
    	classNode.accept(writer);
    	return writer.toByteArray();
    }
}
